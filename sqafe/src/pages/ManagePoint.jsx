import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import { getCalendars } from '../service/apiservice'
import { getUserInfo } from '../service/storage'

export const ManagePoint = () => {
    const navigate = useNavigate();
    const [userInfo, setUserInfo] = useState()
    const [calendars, setCalendars] = useState()

    useEffect(() => {
      const data = getUserInfo()
      console.log(data.data.id);
      setUserInfo(data)
      
      getCalendars(data.data.id)
        .then(res => {
          console.log(res);
          setCalendars(res.data.content)
        })
        .catch(error => toast.error("Có lỗi xảy ra khi lấy dữ liệu"));
    }, [])

    const handleClickCalendar = (id) => {
      navigate(`/manage-point/${id}`)
    }


  return (
    <div className = "container mt-4 d-gird">
      <div className="">Danh sách các lớp mà bạn phụ trách</div>
      <div className="row">
        {
          calendars != null ? calendars.map((c, i) => {
            return <div className="col-sm mt-3" style={{minWidth: "266px", cursor: "pointer"}} key={i} onClick={() => handleClickCalendar(c.id)}>
              <div className="card" style={{width: "100%"}}>
                <div className="card-body">
                  <h5 className="card-title">{c.name}</h5>
                  <p className="card-text">Dịa chỉ: {c.address}</p>
                  <p  className="card-text">Start: {`${c.start[2]}-${c.start[1]}-${c.start[0]} ${c.start[3]}:${c.start[4]}`}</p>
                  <p className="card-text">End: {`${c.end[2]}-${c.end[1]}-${c.end[0]} ${c.end[3]}:${c.end[4]}`}</p>
                </div>
              </div>
            </div>
          }) : <></>
        }
      </div>
    </div>
  )
}
