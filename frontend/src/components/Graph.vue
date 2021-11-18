<template>
  <v-container class="graph-container align-center" fluid>
    <h2 class="my-5 text-center">
      Grafo de disciplinas recomendadas possíveis de serem feitas
    </h2>
    <div id="graph"></div>
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
</style>
