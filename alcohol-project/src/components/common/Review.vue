<template>
  <div>
    <br />
    <b style="font-size: 20px">리뷰 </b>
    <button
      class="btn btn-outline-success"
      @click="openModal"
      style="
        --bs-btn-padding-y: 0.25rem;
        --bs-btn-padding-x: 0.5rem;
        --bs-btn-font-size: 0.6rem;
      "
    >
      리뷰 작성
    </button>
    <table class="table">
      <thead>
        <tr class="table-light">
          <th scope="col">번호</th>
          <th scope="col">작성자</th>
          <th scope="col">내용</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(review, index) in currentReviewList" :key="review.id">
          <td scope="row">{{ (currentPage - 1) * 5 + index + 1 }}</td>
          <td>{{ review.writer }}</td>
          <td>{{ review.content }}</td>
          <td>
            <button
              class="btn btn-outline-success"
              @click="deleteReview(review)"
              v-if="loginUser.id === review.writer"
            >
              삭제
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="pagination" v-if="totalReview">
      <button class="arrow clickable" @click="goFirstPage"><<</button>
      <button class="arrow clickable" @click="prev"><</button>
      <template v-for="num in pageButtonList" :key="num">
        <button
          @click="changePage(num)"
          :class="['clickable', { active: num === currentPage }]"
          v-if="num"
        >
          {{ num }}
        </button>
      </template>
      <button class="arrow clickable" @click="next">></button>
      <button class="arrow clickable" @click="goLastPage">>></button>
    </div>

    <div v-if="isModalOpen" class="modal" style="width: 60%">
      <div class="modal-content">
        <span class="close" @click="closeModal">&times;</span>
        <form @submit.prevent="createReview">
          <div>
            <label for="writer">작성자</label>
            <input class="form-control" :value="loginUser.id" readonly />
          </div>
          <br />
          <div>
            <label for="content">내용</label>
            <textarea
              class="form-control"
              v-model="newReview.content"
              required
            ></textarea>
          </div>
          <button class="btn btn-outline-success" type="submit">
            리뷰 작성
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed, watch } from "vue";
import { useReviewStore } from "@/stores/review";

const store = useReviewStore();
const props = defineProps({
  reviewType: Object,
});

// 현재 로그인한 유저
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));

// 모달창
const isModalOpen = ref(false);

const newReview = ref({
  id: props.reviewType.id,
  writer: loginUser.value.id,
  content: "",
  type: props.reviewType.type,
});

const createReview = async () => {
  await store.createReview(newReview.value);
  newReview.value.content = "";
  closeModal();
  console.log(reviewList.value);
  fetchReviewList();
};

const openModal = () => {
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
};

const totalReview = ref(0);
const currentPage = ref(1);
const reviewList = ref([]);
const currentReviewList = ref([]);

const deleteReview = async (review) => {
  await store.deleteReview(review);
  console.log(reviewList.value);
  fetchReviewList();
};

const fetchReviewList = async () => {
  reviewList.value = [];
  await store.getReviewList(props.reviewType.type, props.reviewType.id);
  totalReview.value = store.reviewList.length;
  reviewList.value = store.reviewList.sort((a, b) => b.reviewId - a.reviewId);
  console.log(reviewList.value);
  // currentPage.value = 1;
  updateCurrentReviewList();
};

const updateCurrentReviewList = () => {
  const start = (currentPage.value - 1) * 5;
  currentReviewList.value = reviewList.value.slice(start, start + 5);
};

const lastPage = computed(() => {
  return Math.ceil(totalReview.value / 5);
});

function prev() {
  if (currentPage.value > 1) {
    currentPage.value -= 1;
    updateCurrentReviewList();
  }
}

function next() {
  if (currentPage.value < lastPage.value) {
    currentPage.value += 1;
    updateCurrentReviewList();
  }
}

function goFirstPage() {
  currentPage.value = 1;
  updateCurrentReviewList();
}

function goLastPage() {
  currentPage.value = lastPage.value;
  updateCurrentReviewList();
}

watch(currentPage, (num) => {
  updateCurrentReviewList();
});

watch(
  () => store.reviewList,
  (newVal) => {
    reviewList.value = newVal;
    totalReview.value = newVal.length;
    updateCurrentReviewList();
  },
  { immediate: true }
);

function changePage(num) {
  if (num !== "") {
    currentPage.value = num;
    updateCurrentReviewList();
  }
}

const pageButtonList = computed(() => {
  let part = Math.ceil(currentPage.value / 5) * 5;
  let arr = [];
  for (let i = part - 4; i <= part; i++) {
    if (i <= lastPage.value) {
      arr.push(i);
    }
  }
  return arr;
});

onMounted(() => {
  fetchReviewList();
});
</script>

<style scoped>
.modal {
  display: block;
  position: fixed;
  z-index: 1;
  padding-top: 100px;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgb(0, 0, 0);
  background-color: rgba(0, 0, 0, 0);
}

.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
  height: 40px;
}

.clickable {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 35px;
  height: 35px;
  margin: 0 5px;
  padding: 5px;
  font-size: 16px;
  color: #333;
  background-color: #fff;
  border: 2px solid #e2ebff;
  border-radius: 50%;
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.clickable:hover {
  background-color: #e2ebff;
  color: #0056b3;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1), 0 2px 4px rgba(0, 0, 0, 0.06);
}

.clickable:active {
  background-color: #c2dbff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1), 0 1px 2px rgba(0, 0, 0, 0.06);
  transform: translateY(1px);
}

.arrow {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 35px;
  height: 35px;
  margin: 0 5px;
  padding: 5px;
  font-size: 16px;
  color: #333;
  background-color: #fff;
  border: 2px solid #e2ebff;
  border-radius: 50%;
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.arrow:hover {
  background-color: #e2ebff;
  color: #0056b3;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1), 0 2px 4px rgba(0, 0, 0, 0.06);
}

.arrow:active {
  background-color: #c2dbff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1), 0 1px 2px rgba(0, 0, 0, 0.06);
  transform: translateY(1px);
}

.active {
  background-color: #c2dbff;
  color: #fff;
  cursor: default;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1), 0 2px 4px rgba(0, 0, 0, 0.06);
}
</style>
