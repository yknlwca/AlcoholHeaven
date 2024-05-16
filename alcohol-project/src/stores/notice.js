import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_NOTICE_API = `http://localhost:8080/api/notice`;

export const useNoticeStore = defineStore('notice', () => {

  const createNotice = function (notice) {
    axios({
      url: REST_NOTICE_API,
      method: 'POST',
      data: notice
    })
      .then(() => {
        router.push({ name: 'noticeList' })
      })
      .catch((error) => {
        console.log(error);
      })
  };

  const noticeList = ref([]);
  const getNoticeList = function () {
    axios.get(REST_NOTICE_API)
      .then((response) => {
        noticeList.value = response.data;
      })
  };

  const notice = ref({});

  const getNotice = function (id) {
    axios.get(REST_NOTICE_API + "/detail/" + `${id}`)
      .then((response) => {
        notice.value = response.data;
      })
  };

  const searchNoticeList = function (searchCondition) {
    axios.get(`${REST_NOTICE_API}/search`, {
      params: searchCondition
    })
      .then((response) => {
        noticeList.value = response.data;
      })
  };

  const updateNotice = function () {
    axios.put(`${REST_NOTICE_API}/${id}`, notice.value)
      .then(() => {
        router.push({ name: 'noticeList' })
      })
  };

  return {
    notice,
    noticeList,
    getNotice,
    searchNoticeList,
    updateNotice,
    createNotice,
    getNoticeList,

  }
});
