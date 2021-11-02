<template>
  <div class="tabs-container">
    <v-tabs v-model="tab" background-color="transparent" class="mb-3" grow>
      <v-tab key="table">Tabela</v-tab>
      <v-tab key="graph">Grafo</v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab" class="transparent">
      <v-tab-item key="table"> <Table /> </v-tab-item>
      <v-tab-item key="graph"> <Graph /></v-tab-item>
    </v-tabs-items>
  </div>
</template>

<script>
import Table from '@/components/Table';
import Graph from '@/components/Graph';
export default {
  data() {
    return { tab: null };
  },
  components: {
    Table,
    Graph,
  },
};
</script>

<style>
.tabs-container {
  width: 100%;
}

.transparent {
  background-color: blue;
}
</style>
