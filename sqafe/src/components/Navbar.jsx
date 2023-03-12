import React from 'react'
import { NavLink } from 'react-router-dom'

function Navbar() {
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
                <li className="nav-item">
                    <NavLink className={({ isActive }) => isActive ? "active nav-link" : "nav-link"} to="/manage-point">Quản Lý Điểm</NavLink>
                </li>
                <li className="nav-item">
                    <NavLink className={({ isActive }) => isActive ? "active nav-link" : "nav-link"} to="/config-point">Cấu Hinh Điểm</NavLink>
                </li>
            </ul>
            <div className="d-flex align-items-center">
                <div className="mr-4">Nguyen Manh Cuong</div>
                <button type="button" className="btn btn-secondary">Logout</button>
            </div>
        </div>
        

    </nav>

  )
}

export default Navbar