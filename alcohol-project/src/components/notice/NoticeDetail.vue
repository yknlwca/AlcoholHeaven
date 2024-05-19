<template>
  <div class="container my-5">
    <h4 style="display: inline-block">제목 : {{ store.notice.title }}</h4>
    <div style="display: inline-block" v-if="loginUser.id==='admin'">
      &nbsp;<button class="btn btn-outline-success btn-sm" @click="openModal">
        수정
      </button>
    </div>
    <hr />
    <br />
    <h4 style="display: inline-block">작성자 :</h4>
    <span> &nbsp;{{ store.notice.userId }}</span>
    <hr />
    <h4>내용</h4>
    <pre>{{ store.notice.content }}</pre>
    <div v-if="isModalOpen" class="modal" style="width: 60%">
      <div class="modal-content">
        <span class="close" @click="closeModal">&times;</span>
          <div>
            <label for="password">비밀번호</label>
            <input class="form-control" v-model="password" />
          </div>
          <div style="display: inline-block">
            &nbsp;<button
              class="btn btn-outline-success btn-sm"
              @click="moveUpdate"
            >
              수정
            </button>
            &nbsp;<button
              class="btn btn-outline-success btn-sm"
              @click="deleteNotice"
            >
              삭제
            </button>
          </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useNoticeStore } from "@/stores/notice";
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const store = useNoticeStore();
const router = useRouter();
const route = useRoute();
const id = ref(route.params.id);
const password = ref("");
onMounted(() => {
  store.getNotice(id.value);
});
// 모달창
const isModalOpen = ref(false);

const openModal = () => {
  isModalOpen.value = true;
  console.log(isModalOpen.value)
};

const closeModal = () => {
  isModalOpen.value = false;
};

const moveUpdate = function () {
  if (password.value == "1234") {
    router.push({ name: "noticeUpdate", params: { id: id.value } });
    password.value = ""
  }else{
    alert("비밀번호가 틀립니다.")
    closeModal();
    password.value = ""
  }
};
const deleteNotice = function () {
  if(password.value == '1234'){
    store.deleteNotice(id.value);
    password.value = ""
  }else{
    alert("비밀번호가 틀립니다.")
    closeModal();
    password.value = ""
  }
  
};
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
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
