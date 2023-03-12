import React from 'react'

export const ModalPoint = () => {
  return (
    
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Sửa điểm thành phần</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item ">Tên SV: <span className="font-weight-light">Nguyễn Mạnh Cường</span></li>
                <li class="list-group-item ">Mã SV: <span className="font-weight-light">B19DCCN083</span> </li>
                <li class="list-group-item d-flex align-items-center">
                    <span class="mr-4" style={{minWidth: "146px"}}>Điểm Điểm Danh:</span> <input type="text" value={"9.9"} onChange={() => {}} class="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                </li>
                <li class="list-group-item d-flex align-items-center">
                    <span class="mr-4" style={{minWidth: "146px"}}>Điểm Kiểm Tra:</span> <input type="text" value={"9.9"} onChange={() => {}} class="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                </li>
                <li class="list-group-item d-flex align-items-center">
                    <span class="mr-4" style={{minWidth: "146px"}}>Điểm Thi Cuối Kì:</span> <input type="text" value={"9.9"} onChange={() => {}} class="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                </li>
            </ul>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Lưu</button>
            </div>
            </div>
        </div>
        </div>
  )
}
