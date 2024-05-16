<template>
  <div
    class="container d-flex flex-column align-items-center"
    style="padding-top: 15px"
  >
    <ALcoholSearch style="width: 37rem" />
    <br />
    <div class="row d-flex" style="width: 38rem">
      <div
        class="card mx-2 my-2 col-12 col-sm-6 col-md-3"
        v-for="alcohol in currentPageAlcoholList"
        :key="alcohol.name"
        style="width: 18rem; padding-top: 10px"
      >
        <img
          src="data:image/jpeg;base64,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"
          class="card-img-top rounded mx-auto d-block"
          alt="..."
          style="height: 150px; width: 150px"
        />
        <div class="card-body">
          <h5 class="card-title">{{ alcohol.name }}</h5>
          <p class="card-text text-truncate">
            {{ alcohol.content }}
          </p>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">지역 : {{ alcohol.region }}</li>
            <li class="list-group-item">
              세부 지역 : {{ alcohol.detailRegion }}
            </li>
            <li class="list-group-item">종류 : {{ alcohol.kindOf }}</li>
          </ul>
        </div>
      </div>
    </div>
    <div>
      <nav aria-label="Page navigation example sticky-top">
        <ul class="pagination d-flex justify-content-center">
          <li class="page-item">
            <a
              class="page-link"
              :class="{ disabled: currentPage <= 1 }"
              @click.prevent="currentPage--"
              href="#"
              >&lt;</a
            >
          </li>
          <li
            class="page-item"
            :class="{ active: currentPage === page }"
            v-for="page in pageCount"
            :key="page"
          >
            <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
              page
            }}</a>
          </li>
          <li class="page-item">
            <a
              class="page-link"
              :class="{ disabled: currentPage >= pageCount }"
              @click.prevent="currentPage++"
              href="#"
              >&gt;</a
            >
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { onMounted, ref, watch, computed } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";
import ALcoholSearch from "./ALcoholSearch.vue";
const route = useRoute();
const name = ref(route.params.name);
const store = useAlcoholStore();
watch(
  () => route.params.name,
  (newName) => {
    name.value = newName;
  }
);
// const alcoholList = ref(store.getAlcoholList(name.value));
watch(
  () => store.getAlcoholList(name.value),
  (newList) => {
    store.alcoholList.value = newList;
  }
);

onMounted(() => {
  name.value = route.params.name;
  store.getAlcoholList(name.value);
});
const perPage = 4;
const currentPage = ref(1);
const pageCount = computed(() => {
  return Math.ceil(store.alcoholList.length / perPage);
});
const clickPage = function (page) {
  currentPage.value = page;
};
const currentPageAlcoholList = computed(() => {
  return store.alcoholList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
</script>

<style scoped></style>
