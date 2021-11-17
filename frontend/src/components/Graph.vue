<template>
  <v-container id="cu" class="container" fluid>
    <h1>Grafo de disciplinas recomendadas possíveis de serem feitas</h1>
    <svg id="graph"></svg>
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
    console.log(this.possibleRecommendations);
    GraphGenerator({
      nodes: this.possibleRecommendations.nodes,
      links: this.possibleRecommendations.links,
      width: this.$el.querySelector('svg').style.width,
      height: this.$el.querySelector('svg').style.height,
      container: this.$el.querySelector('svg'),
    });
  },
};
</script>

<style scoped>
.container {
  height: 400px;
}

#graph {
  width: 100%;
  height: 100%;
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
