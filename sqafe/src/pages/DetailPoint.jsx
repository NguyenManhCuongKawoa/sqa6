import React from 'react'
import { ModalPoint } from '../components/ModalPoint'

const DetailPoint = () => {
  return (
    <div className = "container mt-4 ">
        <div className="text-uppercase font-weight-bold mb-1">Thông tin cơ bản</div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item ">Tên lịch: <span className="font-weight-light">Lịch học 1 (Java)</span></li>
            <li class="list-group-item ">Địa Chỉ: <span className="font-weight-light">Phòng 302 A2</span> </li>
            <li class="list-group-item ">Môn học: <span className="font-weight-light">Lập trình java</span></li>  
            <li class="list-group-item ">Thời gian bắt đầu: <span className="font-weight-light">2022-11-22 09:00:00</span></li>
            <li class="list-group-item ">Thời gian kết thúc: <span className="font-weight-light">2022-11-22 11:00:00</span></li>
        </ul>


        <div className="text-uppercase font-weight-bold mb-1 mt-4">Danh sách sinh viên</div>
        <div className="">
            <table class="table table-sm table-hover">
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
                    <tr data-toggle="modal" data-target="#exampleModalLong" style={{cursor: "pointer"}}>
                        <th scope="row">1</th>
                        <td>Nguyễn Mạnh Cường</td>
                        <td>B19DCCN083</td>
                        <td>9.9</td>
                        <td>9.9</td>
                        <td>9.9</td>
                        <td>9.9</td>
                        <td class="btn-success">Success</td>
                    </tr>
                    <tr data-toggle="modal" data-target="#exampleModalLong" style={{cursor: "pointer"}}>
                        <th scope="row">2</th>
                        <td>Nguyễn Văn A</td>
                        <td>B19DCCN888</td>
                        <td>3.9</td>
                        <td>3.9</td>
                        <td>3.9</td>
                        <td>3.9</td>
                        <td class="btn-danger">Fail</td>
                    </tr>
                    
                </tbody>
            </table>
        </div>
        <ModalPoint />
    </div>
  )
}

export default DetailPoint