<template>
  <validation-observer ref="observer" v-slot="{ invalid }">
    <v-card class="pb-3">
    <!-- Dialog title -->
    <v-card-title class="justify-space-between">
      <span class="text-h5">Add a new filter</span>
      <span class="close-btn" @click="close">X</span>
    </v-card-title>

    <!-- Dialog body -->
    <v-card-text>
      <v-container>
        <form @submit.prevent="submit">
          <!-- Filter name -->
          <v-row>
            <v-col cols="12" sm="2" md="2" class="input-title">
              Filter name
            </v-col>
            <v-col cols="12" sm="3" md="3">
              <validation-provider v-slot="{ errors }" name="Filter name" rules="required|max:255">
                <v-text-field
                    label="Filter name"
                    v-model="form.filterName"
                    :error-messages="errors"
                    required></v-text-field>
              </validation-provider>
            </v-col>
          </v-row>

          <!-- Criteria -->
          <v-row v-for="i in form.criteria.length">
            <!-- Title -->
            <v-col cols="12" md="2" sm="2" class="input-title">
              <div v-if="i === 1">Criteria</div>
            </v-col>
            <!-- Type -->
            <FilterTypeInput :criteria="form.criteria[i - 1]"></FilterTypeInput>
            <!-- Condition -->
            <FilterConditionInput :criteria="form.criteria[i - 1]"></FilterConditionInput>
            <!-- Value -->
            <FilterValueInput :criteria="form.criteria[i - 1]"></FilterValueInput>
            <!-- Remove -->
            <v-col cols="12" md="1" sm="1" class="ma-auto">
              <v-btn @click="remove(i - 1)" color="pink" dark class="remove-criteria-btn px-3">-</v-btn>
            </v-col>
          </v-row>

          <!-- Add row button -->
          <v-row>
            <v-col cols="12" md="2" sm="2"></v-col>
            <v-col cols="12" md="9" sm="9" class="text-center">
              <v-btn color="grey darken-1" dark @click="addRow">+  Add row</v-btn>
            </v-col>
          </v-row>

          <!-- Selection -->
          <v-row>
            <v-col cols="12" md="2" sm="2" class="input-title">
              Selection
            </v-col>
            <FilterSelectionInput :form="form"></FilterSelectionInput>
          </v-row>

        </form>
      </v-container>
    </v-card-text>

    <!-- Close and save buttons -->
    <v-card-actions class="justify-center">
      <v-btn color="grey darken-1"
             class="action-btn justify-center"
             dark
             @click="close">
        Close
      </v-btn>
      <v-btn color="primary darken-1"
             class="action-btn"
             type="submit"
             :disabled="invalid || saving || !valid"
             @click="save">
        Save
      </v-btn>
    </v-card-actions>
  </v-card>
  </validation-observer>

</template>

<script>
import FilterTypeInput from "@/components/Inputs/FilterTypeInput";
import FilterConditionInput from "@/components/Inputs/FilterConditionInput";
import FilterValueInput from "@/components/Inputs/FilterValueInput";
import {filterConditionsByType, filterTypes} from "@/types/FiltersConditions";
import FilterSelectionInput from "@/components/Inputs/FilterSelectionInput";

import { required, max } from 'vee-validate/dist/rules';
import { extend, setInteractionMode, ValidationObserver, ValidationProvider } from "vee-validate";

// https://vuetifyjs.com/en/components/forms/#vuelidate

setInteractionMode('eager');

extend('required', {
  ...required,
  message: '{_field_} can not be empty.'
});

extend('max', {
  ...max,
  message: '{_field_} may not be longer than {length} digits.'
});

export default {
  name: "NewFilterForm",
  components: {FilterSelectionInput, FilterValueInput, FilterConditionInput, FilterTypeInput, ValidationObserver, ValidationProvider},
  data() {
    return {
      saving: false,
      form: {}
    }
  },
  beforeMount() {
    this.resetForm();
  },
  methods: {
    remove(index) {
      this.form.criteria.splice(index, 1);
      if (this.form.criteria.length === 0) {
        this.addRow();
      }
    },
    addRow() {
      this.form.criteria.push({filterType: filterTypes[0], condition: filterConditionsByType[filterTypes[0]][0], value: undefined});
    },
    resetForm() {
      this.form = {
        filterName: '',
        criteria: [],
        selection: 'Selection 1'
      };
      this.addRow();
    },
    close() {
      this.resetForm();
      this.$refs.observer.reset();
      this.$emit('close');
    },
    save() {
      this.$refs.observer.validate();
      if (!this.valid) {
        return;
      }
      this.saving = true;
      const payload = this.form;
      this.$store
          .dispatch("filters/save", JSON.stringify(payload))
          .then(() => {
            this.saving = false;
            this.$emit('saved');
            this.close();
          }).catch(e => {
        console.log(e);
        this.saving = false;
      })
    }
  },
  computed: {
    valid() {
      if (!this.form.filterName?.length) {
        return false;
      }
      for (const criteria of this.form.criteria) {
        if (!criteria.filterType?.length || !criteria.condition?.length) {
          return false;
        }
        switch (criteria.filterType) {
          case 'AMOUNT':
            if (criteria.value === undefined) {
              return false;
            }
            break;
          case 'TITLE':
          case 'DATE':
            if (!criteria.value?.length) {
              return false;
            }
        }
      }
      return true;
    }
  },
  events: {
    saved() {
      console.log('huh...')
    }
  }
}
</script>

<style scoped lang="css">

.input-title {
  color: black;
  font-weight: bold;
}

.remove-criteria-btn {
  min-width: min-content !important;
  font-size: 26px;
}

.action-btn {
  width: 150px;
}

.close-btn {
  font-size: 26px;
  cursor: pointer;
}
</style>
