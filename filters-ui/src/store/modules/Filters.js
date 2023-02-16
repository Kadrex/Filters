import {getFilters, save} from "@/api/Filters.api";

export default {
    namespaced: true,
    state: {
        items: []
    },
    actions: {
        fetchAll() {
            return getFilters();
        },
        save({commit}, payload) {
            return save(payload);
        }
    }
}
