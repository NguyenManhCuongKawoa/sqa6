import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import { ModalPoint } from '../components/ModalPoint'
import { enterPoint, getCalendarDetail } from '../service/apiservice'

const DetailPoint = () => {
    let { calendarId } = useParams();
    const [calendar, setCalendar] = useState()
    const [svClicked, setSvClicked] = useState()

    useEffect(() => {
        getDataCalendar()
      
    }, [])

    const getDataCalendar = () => {
        getCalendarDetail(calendarId)
            .then(res => {
                console.log(res.data);
                setCalendar(res.data)
            })
            .catch(error => toast.error("Có lỗi xảy ra khi lấy dữ liệu"));
    }    

    const updatePoint = (svPointChanged) => {
        console.log(svPointChanged);

        let body = {
            "monhocId": calendar.monHocId, 
            "points": [
                {
                    "svId": svPointChanged.svId,
                    "dauDiemId": 1,
                    "point": svPointChanged.points[0]
                },
                {
                    "svId": svPointChanged.svId,
                    "dauDiemId": 2,
                    "point": svPointChanged.points[1]
                },
                {
                    "svId": svPointChanged.svId,
                    "dauDiemId": 3,
                    "point": svPointChanged.points[2]
                }
            ]
        }

        console.log(body);
        enterPoint(body)
        getDataCalendar()
        toast.info("Cập nhật điểm thành công")
    }

  return (
    <div className = "container mt-4 ">
        <div className="text-uppercase font-weight-bold mb-1">Thông tin cơ bản</div>
        <ul className="list-group list-group-flush">
            <li className="list-group-item ">Tên lịch: <span className="font-weight-light">{calendar ? calendar.name : ""}</span></li>
            <li className="list-group-item ">Địa Chỉ: <span className="font-weight-light">{calendar ? calendar.address : ""}</span> </li>
            <li className="list-group-item ">Môn học: <span className="font-weight-light">{calendar ? calendar.tenMonHoc : ""}</span></li>  
            <li className="list-group-item ">Thời gian bắt đầu: <span className="font-weight-light">{calendar ? `${calendar.start[2]}-${calendar.start[1]}-${calendar.start[0]} ${calendar.start[3]}:${calendar.start[4]}`  : ""}</span></li>
            <li className="list-group-item ">Thời gian kết thúc: <span className="font-weight-light">{calendar ? `${calendar.end[2]}-${calendar.end[1]}-${calendar.end[0]} ${calendar.end[3]}:${calendar.start[4]}`  : ""}</span></li>
        </ul>

        <div className="text-uppercase font-weight-bold mb-1 mt-4">Thống kê sinh viên</div>
        <ul class="list-group">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Số sinh viên được thi
                <span class="badge badge-primary badge-pill" style={{backgroundColor: "#28a745"}}>{calendar ? calendar.numSvPast : '-'}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Số sinh viên không được thi
                <span class="badge badge-primary badge-pill" style={{backgroundColor: "#dc3545"}}>{calendar ? calendar.numSvFail : '-'}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Số sinh viên chưa cấp nhật điểm
                <span class="badge badge-primary badge-pill">{calendar ? calendar.numSvBlank : '-'}</span>
            </li>
        </ul>

        <div className="text-uppercase font-weight-bold mb-1 mt-4">Danh sách sinh viên</div>
        <div className="">
            <table className="table table-sm table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên SV</th>
                        <th scope="col">Mã SV</th>
                        <th scope="col">Điểm Điểm Danh</th>
                        <th scope="col">Điểm Kiểm Tra</th>
                        <th scope="col">Điểm Thi Cuối Kì</th>
                        <th scope="col">Điểm Tổng kế</th>
                        <th scope="col">Trạng Thái</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        calendar ? calendar.sv.map((sv, i) => {
                            return  <tr data-toggle="modal" data-target="#exampleModalLong" key={i} style={{cursor: "pointer"}} onClick={() => setSvClicked(sv)}>
                                <th scope="row">{i + 1}</th>
                                <td>{sv.name}</td>
                                <td>{sv.masv}</td>
                                <td>{sv.points[0] ? sv.points[0] : '-'}</td>
                                <td>{sv.points[1] ? sv.points[1] : '-'}</td>
                                <td>{sv.points[2] ? sv.points[2] : '-'}</td>
                                <td>{sv.finalPoint ? sv.finalPoint : '-'}</td>
                                {sv.finalPoint == null ? <td></td> : sv.past == true ? <td className="btn-success">Past</td> : <td className="btn-danger">Fail</td>}
                            </tr>
                        }) : <></>
                    }
                </tbody>
            </table>
        </div>
        <ModalPoint sv = {svClicked} updatePoint = {updatePoint}/>
    </div>
  )
}

export default DetailPoint