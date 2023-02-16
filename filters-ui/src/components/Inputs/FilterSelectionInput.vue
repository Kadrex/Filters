<template>
  <v-col cols="12" md="9" sm="9">
    <v-radio-group v-model="form.selection" mandatory class="mt-0">
      <v-row>
        <v-col cols="12" md="3" sm="4">
          <v-radio label="Selection 1" value="Selection 1"></v-radio>
        </v-col>
        <v-col cols="12" md="3" sm="4">
          <v-radio label="Selection 2" value="Selection 2"></v-radio>
        </v-col>
        <v-col cols="12" md="3" sm="4">
          <v-radio label="Selection 3" value="Selection 3"></v-radio>
        </v-col>
      </v-row>
    </v-radio-group>
  </v-col>
</template>

<script>
export default {
  name: "FilterSelectionInput",
  props: {
    form: {
      filterName: String,
      criteria: Array,
      selection: String
    }
  }
}
</script>

<style scoped>

</style>
