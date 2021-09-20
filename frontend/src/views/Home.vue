<template>
	<div class="home">
    <v-toolbar flat class="d-flex">
      <v-toolbar-items class="d-flex">

        <div class="link"> <router-link to="/">Home</router-link> </div>
        <div class="link"> <router-link to="/painel">Meu Painel</router-link></div>
        <div class="link"> <router-link to="/disciplinas">Disciplinas</router-link></div>

      </v-toolbar-items>
  </v-toolbar>
		
    <main>
			<h1></h1>
		</main>
	</div>
</template>

<script>
export default {
	name: 'Home'
}
</script>

<style>
  .link {
    margin-right: 8px;
  }

</style>