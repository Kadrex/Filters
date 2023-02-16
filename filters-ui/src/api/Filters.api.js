import httpClient from "@/api/HttpClient";

const getFilters = () => httpClient.get('getFilters');
const save = payload => httpClient.post('saveFilter', payload);

export {
    getFilters,
    save
}
