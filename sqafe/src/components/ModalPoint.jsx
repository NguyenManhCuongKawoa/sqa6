import React, { useEffect, useState } from 'react'
import { toast } from 'react-toastify'

export const ModalPoint = ({sv, updatePoint}) => {
    const[point1, setPoint1] = useState("")
    const[point2, setPoint2] = useState("")
    const[point3, setPoint3] = useState("")

    useEffect(() => {
        setPoint1(sv && sv.points[0] ? sv.points[0] : "")
        setPoint2(sv && sv.points[1] ? sv.points[1] : "")
        setPoint3(sv && sv.points[2] ? sv.points[2] : "")
    }, [sv])

    const handleChangeValue1 = (event) => {
        if(event.target.value >= 0 && event.target.value <= 10) {
            sv.points[0] = event.target.value; 
            setPoint1(event.target.value)
        } else {
            toast.warn("Điểm phải lớn hơn 0 và nhở hơn 10")
        }
    }

    const handleChangeValue2 = (event) => {
        if(event.target.value >= 0 && event.target.value <= 10) {
            sv.points[1] = event.target.value; 
            setPoint2(event.target.value)
        } else {
            toast.warn("Điểm phải lớn hơn 0 và nhở hơn 10")
        }
    }

    const handleChangeValue3 = (event) => {
        if(event.target.value >= 0 && event.target.value <= 10) {
            sv.points[2] = event.target.value; 
            setPoint3(event.target.value)
        } else {
            toast.warn("Điểm phải lớn hơn 0 và nhở hơn 10")
        }
    }

  return (
    
        <div className="modal fade" id="exampleModalLong" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div className="modal-dialog" role="document">
            <div className="modal-content">
            <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLongTitle">Sửa điểm thành phần</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item ">Tên SV: <span className="font-weight-light">{sv ? sv.name : ""}</span></li>
                    <li className="list-group-item ">Mã SV: <span className="font-weight-light">{sv ? sv.masv : ""}</span> </li>
                    <li className="list-group-item d-flex align-items-center">
                        <span className="mr-4" style={{minWidth: "146px"}}>Điểm Điểm Danh:</span> <input type="number" value={point1} min={0} max={10} onChange={handleChangeValue1} className="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                    </li>
                    <li className="list-group-item d-flex align-items-center">
                        <span className="mr-4" style={{minWidth: "146px"}}>Điểm Kiểm Tra:</span> <input type="number" value={point2} min={0} max={10} onChange={handleChangeValue2} className="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                    </li>
                    <li className="list-group-item d-flex align-items-center">
                        <span className="mr-4" style={{minWidth: "146px"}}>Điểm Thi Cuối Kì:</span> <input type="number" value={point3} min={0} max={10} onChange={handleChangeValue3} className="form-control " style={{flex: "1"}} aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
                    </li>
                </ul>
                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" className="btn btn-primary" data-dismiss="modal" onClick={() => updatePoint(sv)}>Lưu</button>
                </div>
            </div>
        </div>
    </div>
  )
}
