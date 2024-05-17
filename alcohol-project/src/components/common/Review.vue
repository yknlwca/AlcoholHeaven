<template>
  <div>
    <br />
    <b style="font-size: 20px">리뷰 </b
    ><button class="btn btn-outline-success" @click="openModal">
      리뷰 작성
    </button>
    <table class="table ">
      <thead>
        <tr class="table-light">
          <th scope="col">번호</th>
          <th scope="col">작성자</th>
          <th scope="col">내용</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(review, index) in store.reviewList" :key="review.id">
          <td scope="row">{{ index + 1 }}</td>
          <!-- <td> {{ review.reviewId }}</td> -->
          <td>{{ review.writer }}</td>
          <td>{{ review.content }}</td>
          <button
              class="btn btn-outline-success"
              @click="deleteReview(review)"
              v-if="loginUser.id === review.writer"
            >
              삭제
            </button>
        </tr>
      </tbody>
    </table>

    <div v-if="isModalOpen" class="modal" style="width: 60%">
      <div class="modal-content">
        <span class="close" @click="closeModal">&times;</span>
        <form @submit.prevent="createReview">
          <div>
            <label for="writer">작성자</label>
            <input class="form-control" :value="loginUser.id" readonly/>
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
import { ref, onMounted } from "vue";
import { useReviewStore } from "@/stores/review";
const store = useReviewStore();
const props = defineProps({
  reviewType: Object,
});
onMounted(() => {
  store.getReviewList(props.reviewType.type, props.reviewType.id);
  console.log(props.reviewType.id);
  console.log(props.reviewType.type);
});
//현재 로그인한 유저
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")))
// 리뷰
const deleteReview = (review) => {
  store.deleteReview(review);
};

// 모달창
const isModalOpen = ref(false);

const newReview = ref({
  id: props.reviewType.id,
  writer: loginUser.value.id,
  content: "",
  type: props.reviewType.type,
});

const createReview = () => {
  // console.log("잘되나요", newReview.value);/
  store.createReview(newReview.value);
  newReview.value.writer = "";
  newReview.value.content = "";
  closeModal();
};

const openModal = () => {
  // console.log(loginUser.value.id)
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
};
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
</style>
