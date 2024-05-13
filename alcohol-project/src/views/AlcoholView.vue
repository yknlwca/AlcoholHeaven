<template>
  <div id="map"></div>
</template>
<script setup>
import * as d3 from "d3";
import { onMounted } from "vue";
onMounted(() => {
  drawMap("#map");
});

//지도 그리기
function drawMap(target) {
  var width = 700; //지도의 넓이
  var height = 700; //지도의 높이
  var initialScale = 5500; //확대시킬 값
  var initialX = -11900; //초기 위치값 X
  var initialY = 4050; //초기 위치값 Y
  var labels;

  var projection = d3
    .geoMercator()
    .scale(initialScale)
    .translate([initialX, initialY]);
  var path = d3.geoPath().projection(projection);

  var svg = d3
    .select(target)
    .append("svg")
    .attr("width", width + "px")
    .attr("height", height + "px")
    .attr("id", "map")
    .attr("class", "map");

  var states = svg.append("g").attr("id", "states");
  states
    .append("rect")
    .attr("class", "background")
    .attr("width", width + "px")
    .attr("height", height + "px")
    .attr("fill", "white");

  
  d3.json("/src/assets/json/korea.json")
    .then(function (json) {
      // console.log(json); // 데이터 로드 확인
      // console.log(json.features);
      const statesSelection = states.selectAll("path").data(json.features);

      // Enter 선택자를 사용하여 새 path 요소 추가
      statesSelection
        .enter()
        .append("path")
        .attr("d", path)
        .attr("id", (d) => "path-" + d.properties.name_eng)
        .attr("class", "region")
        .on("click", (d) => {
          // console.log(d)
          // console.log(d.target.__data__.properties.name)
          handleRegionClick(d.target.__data__.properties.name); // 클릭 이벤트 핸들러
        });

      // 텍스트 레이블을 위한 Enter 선택자
      labels = states.selectAll("text").data(json.features);

      labels
        .enter()
        .append("text")
        .attr("transform", translateTolabel)
        .attr("id", (d) => "label-" + d.properties.name_eng)
        .attr("text-anchor", "middle")
        .attr("dy", ".35em")
        .text((d) => d.properties.name);
    })
    .catch(function (error) {
      console.error("Error loading the JSON data: ", error); // 오류 로깅
    });

  //텍스트 위치 조절 - 하드코딩으로 위치 조절을 했습니다.
  function translateTolabel(d) {
    const centroid = path.centroid(d);
    const offset = initialScale / height;
    // 조건에 따라 y 위치 조정
    if (d.properties.code == 31) {
      // 서울
      centroid[1] += offset + 20;
    } else if (d.properties.code == 34) {
      // 충청남도
      centroid[1] += offset + 10;
    }
    return `translate(${centroid})`;
  }

  function handleRegionClick(regionName) {
    console.log("Clicked on region:", regionName); // 클릭된 지역 이름 로깅
  }
  
}
</script>
<style scoped>
@charset "UTF-8";

#container {
  width: 700px;
  min-height: 700px;
  float: left;
  margin: 15px 35px;
}

#states path {
  fill: #585858;
  stroke: #000000;
  stroke-width: 1.5px;
}

#states path:hover {
  fill: #009300;
}

#states .active {
  fill: #00b700;
}

#states .activeDetail {
  fill: #00b700;
}

#states path {
  cursor: pointer;
}

#states text {
  cursor: pointer;
  font-size: 12px;
  fill: #fff;
}
</style>
