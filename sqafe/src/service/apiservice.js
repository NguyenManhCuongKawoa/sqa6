import axios from "axios";

const hostbe = 'http://localhost:8080'; 

export function login(data) {
    return axios.post(`${hostbe}/api/user`, data);
}

export function getSubjects() {
    return axios.get(`${hostbe}/api/subject`);
}

export function configPoints(id, body) {
    return axios.post(`${hostbe}/api/config-point?monHocId=${id}`, body);
}

export function fixPoints(id, body) {
    return axios.put(`${hostbe}/api/config-point?monHocId=${id}`, body);
}

export function getConfigPoints(id) {
    return axios.get(`${hostbe}/api/config-point?monHocId=${id}`);
}


export function getCalendars(id) {
    return axios.get(`${hostbe}/api/calendar?teacherId=${id}`);
}

export function getCalendarDetail(id) {
    return axios.get(`${hostbe}/api/calendar/info-class?calendarId=${id}`);
}

export function enterPoint(body) {
    return axios.post(`${hostbe}/api/enter-point`, body);
}