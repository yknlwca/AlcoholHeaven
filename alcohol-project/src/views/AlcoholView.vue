<template>
  <div id="container"></div>
</template>
<script setup>
import * as d3 from "d3";
import { onMounted } from "vue";
onMounted(() => {
  drawMap("#container");
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
  // .call(zoom);
  states
    .append("rect")
    .attr("class", "background")
    .attr("width", width + "px")
    .attr("height", height + "px")
    .attr("fill", "white");

  //geoJson데이터를 파싱하여 지도그리기
  d3.json("/src/assets/json/korea.json", function (json) {
    console.log(json);
    states
      .selectAll("path") //지역 설정
      .data(json.features)
      .enter()
      .append("path")
      .attr("d", path)
      .attr("id", function (d) {
        return "path-" + d.properties.name_eng;
      })
      .attr("class", "region") // 클래스 추가
      .on("click", function (d) {
        // 클릭 이벤트 핸들러
        handleRegionClick(d.properties.name); // 해당 지역 이름을 전달하여 처리
      });

    labels = states
      .selectAll("text")
      .data(json.features) //라벨표시
      .enter()
      .append("text")
      .attr("transform", translateTolabel)
      .attr("id", function (d) {
        return "label-" + d.properties.name_eng;
      })
      .attr("text-anchor", "middle")
      .attr("dy", ".35em")
      .text(function (d) {
        return d.properties.name;
      });
  });

  //텍스트 위치 조절 - 하드코딩으로 위치 조절을 했습니다.
  function translateTolabel(d) {
    var arr = path.centroid(d);
    if (d.properties.code == 31) {
      //서울 경기도 이름 겹쳐서 경기도 내리기
      arr[1] +=
        d3.event && d3.event.scale
          ? d3.event.scale / height + 20
          : initialScale / height + 20;
    } else if (d.properties.code == 34) {
      //충남은 조금 더 내리기
      arr[1] +=
        d3.event && d3.event.scale
          ? d3.event.scale / height + 10
          : initialScale / height + 10;
    }
    return "translate(" + arr + ")";
  }
  //지역 클릭 함수
  function handleRegionClick(regionName) {
    console.log("Clicked on region:", regionName);
    // 여기에 클릭한 지역에 대한 추가적인 처리를 작성할 수 있습니다.
    // 예: 해당 지역 페이지로 이동하거나 다른 동작 수행 등
  }
  // d3.json("/src/assets/json/korea.json")
  //   .then(function (json) {
  //     console.log(json); // 데이터 로드 확인

  //     const statesSelection = states.selectAll("path").data(json.features);

  //     // Enter 선택자를 사용하여 새 path 요소 추가
  //     statesSelection
  //       .enter()
  //       .append("path")
  //       .attr("d", path)
  //       .attr("id", (d) => "path-" + d.properties.name_eng)
  //       .attr("class", "region")
  //       .on("click", (d) => {
  //         handleRegionClick(d.properties.name); // 클릭 이벤트 핸들러
  //       });

  //     // 텍스트 레이블을 위한 Enter 선택자
  //     const labelsSelection = states.selectAll("text").data(json.features);

  //     labelsSelection
  //       .enter()
  //       .append("text")
  //       .attr("transform", translateTolabel)
  //       .attr("id", (d) => "label-" + d.properties.name_eng)
  //       .attr("text-anchor", "middle")
  //       .attr("dy", ".35em")
  //       .text((d) => d.properties.name);
  //   })
  //   .catch(function (error) {
  //     console.error("Error loading the JSON data: ", error); // 오류 로깅
  //   });

  // //텍스트 위치 조절 - 하드코딩으로 위치 조절을 했습니다.
  // function translateTolabel(d) {
  //   const centroid = path.centroid(d);
  //   const offset = initialScale / height;
  //   // 조건에 따라 y 위치 조정
  //   if (d.properties.code == 31) {
  //     // 서울
  //     centroid[1] += offset + 20;
  //   } else if (d.properties.code == 34) {
  //     // 충청남도
  //     centroid[1] += offset + 10;
  //   }
  //   return `translate(${centroid})`;
  // }

  // function handleRegionClick(regionName) {
  //   console.log("Clicked on region:", regionName); // 클릭된 지역 이름 로깅
  // }
  const container = document.querySelector("#container");
  console.log(container);
  // console.log(1);
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
