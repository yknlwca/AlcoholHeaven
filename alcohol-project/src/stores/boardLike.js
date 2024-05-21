import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useLikeStore = defineStore('boardLike', () => {
  const REST_LIKE_API = 'http://localhost:8080/api/boardLike'
 
  const clickLike = async function (boardLike) {
     await axios({
        url: `${REST_LIKE_API}/click-like`,
        method: 'POST',
        data: boardLike,
      })
      .then(() => {
        console.log("좋아요 클릭")
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const removeLike = async function (boardLike) {
    await axios({
      url: `${REST_LIKE_API}/remove-like`,
      method: 'DELETE',
      data: boardLike,
    })
      .then(() => {
        console.log("좋아요 취소")
      })
      .catch((error) => {
        console.log(error);
      });
  };
  // const likeCnt = function(type, id){
  //   axios.get(`${REST_LIKE_API}/${type}/${id}`)
  //   .then((response)=>{
  //       console.log(response.data)
  //       return response.data;
  //   })
  // }
  const likeCnt = async function(type, id) {
    try {
        const response = await axios.get(`${REST_LIKE_API}/${type}/${id}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}


  const check = async function(boardLike) {
    try {
        const response = await axios.get(`${REST_LIKE_API}/check`, {
            params: boardLike
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}

  return {clickLike, removeLike, likeCnt,check }
},{
  persist: true,
},)
