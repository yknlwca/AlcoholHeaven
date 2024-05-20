import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_REVIEW_API = `http://localhost:8080/api/review`;

export const useReviewStore = defineStore('review', () => {
  // review
  const reviewList = ref([]);

  const review = ref({});

  const getReviewList = function (type,id) {
    // 술1, 음식2, 친구3
    axios.get(`${REST_REVIEW_API}/${type}/${id}`)
      .then((response) => {
        // console.log(response);
        reviewList.value = response.data;

      })
      .catch((error) => {
        console.log(error);
      })
  };

  const createReview = function (review) {
    axios({
      url: REST_REVIEW_API,
      method: 'POST',
      data: review
    })
      .then(() => {
        getReviewList(review.type,review.id);
      })
      .catch((error) => {
        console.log(error);
      })
  };



  const deleteReview = function (review) {
    axios
      .delete(`${REST_REVIEW_API}/${review.reviewId}`)
      .then(() => {
        // 삭제 후 리뷰 목록 갱신
        getReviewList(review.type, review.id);
      })
      .catch((error) => {
        console.log(error);
      });
  };



  return {
    reviewList,
    review,
    getReviewList,
    createReview,
    deleteReview
  }
});
