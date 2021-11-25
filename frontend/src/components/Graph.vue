<template>
  <v-container class="graph-container align-center d-flex flex-column" fluid>
    <h2 class="my-5 text-center">
      Grafo de disciplinas recomendadas possíveis de serem feitas
    </h2>

    <div id="graph"></div>
    <div
      class="
        mt-1
        d-flex
        flex-column
        align-self-center
        justify-center
        border
        legend-size
      "
    >
      <h2 class="text-center mt-3">Legenda</h2>
      <div class="my-5 d-flex align-self-center">
        <span class="border rounded-circle pa-4 mx-2 approved-green"
          >Aprovada</span
        >
        <span class="border rounded-circle pa-4 mx-2 available-white"
          >Disponível</span
        >
        <span
          class="border rounded-circle pa-4 mx-2 available-white blocked-text"
          >Bloqueada</span
        >
      </div>
    </div>
  </v-container>
</template>

<script>
import GraphGenerator from '@/plugins/graph';
export default {
  props: {
    possibleRecommendations: {
      type: Object,
      required: true,
    },
  },
  mounted() {
    const frame = document.getElementById('graph');
    GraphGenerator({
      data: this.possibleRecommendations,
      width: frame.clientWidth,
      height: frame.clientHeight,
      container: frame,
    });
  },
};
</script>

<style scoped>
.graph-container {
  height: 100vh;
}

#graph {
  border: 1px solid #6666;
  width: 100%;
  height: 70%;
}

.link {
  stroke: #000;
}
.node {
  cursor: move;
  fill: #ccc;
  stroke: #000;
  stroke-width: 1.5px;
}
.border {
  border: 1px solid #6666;
}
.legend-size {
  width: 50%;
}
.approved-green {
  background-color: #cee7cc;
}
.available-white {
  background-color: white;
}
.blocked-text {
  color: #868b8e;
}
</style>
