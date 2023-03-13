import clsx from 'clsx';
import React, { useEffect, useState } from 'react'
import { Link, NavLink, useNavigate } from 'react-router-dom'
import { getUserInfo, removeUserInfo, userRole } from '../service/storage'

function Navbar() {
    const navigate = useNavigate();
    const [userInfo, setUserInfo] = useState()

    const [role, setRole] = useState()
    useEffect(() => {
        setRole(userRole())
    }, [])

    useEffect(() => {
        const data = getUserInfo()
        console.log(data);
        setUserInfo(data)
    
    }, [])
    
    const handleLogout = () => {
        navigate("/login")
        removeUserInfo()
    }


  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="#">SQA 6</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse justify-content-between" id="navbarNav">
            <ul className="navbar-nav">
                <li className="nav-item">
                    <NavLink className={({ isActive }) => isActive ? "active nav-link" : "nav-link"} to="/" >Trang chủ</NavLink>
                </li>
                {
                    role == "GIANG_VIEN" ? <li className="nav-item">
                        <NavLink className={({ isActive }) => isActive ? "active nav-link" : "nav-link"} to="/manage-point">Quản Lý Điểm</NavLink>
                    </li> : role == 'QUAN_LY' ? <li className="nav-item">
                        <NavLink className={({ isActive }) => isActive ? "active nav-link" : "nav-link"} to="/config-point">Cấu Hinh Điểm</NavLink>
                    </li> : <></>
                }
                
                
                
            </ul>
            <div className={clsx("align-items-center", {"d-none": role == null, "d-flex": role != null})}>
                <div className="mr-4">{userInfo != null ? userInfo.data.name : ""}</div>
                <button type="button" className="btn btn-secondary" onClick={handleLogout}>Logout</button>
            </div>

            <div className={clsx("align-items-center", {"d-none": role != null, "d-flex": role == null})}>
                <Link to={"/login"} className="btn btn-info">Login</Link>
            </div>
        </div>
        

    </nav>

  )
}

export default Navbar