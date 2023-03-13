export function saveUserInfo(data) {
    localStorage.setItem('user', JSON.stringify(data));
}

export function getUserInfo() {
    return JSON.parse(localStorage.getItem('user'));
}

export function removeUserInfo() {
    localStorage.removeItem('user');
}

export function userRole() {
    let data = localStorage.getItem('user')
    if(data == null) return null
    let user = JSON.parse(data)

    return user.role
}