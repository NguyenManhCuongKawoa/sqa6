import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import Login from "./pages/login";
import Main from "./Main";
import { NotFound } from "./NotFound";
import ConfigPoint from "./pages/ConfigPoint";
import DetailPoint from "./pages/DetailPoint";
import { Home } from "./pages/Home";
import { ManagePoint } from "./pages/ManagePoint";

import 'react-toastify/dist/ReactToastify.css';
import { useEffect, useState } from "react";
import { userRole } from "./service/storage";

function App() {
  const [role, setRole] = useState()
  useEffect(() => {
    setRole(userRole())
  }, [])
  
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" exact element={<Login />} />

        <Route path="/" element={<Main />} >
          <Route index element={<Home />} />
          {/* {
            role == "GIANG_VIEN" ? <>
              <Route path="manage-point" element={<ManagePoint />} />
              <Route path="manage-point/:calendarId" element={<DetailPoint />} />
            </> : role == 'QUAN_LY' ? <Route path="config-point" element={<ConfigPoint />} /> : <></>
          } */}
            <Route path="manage-point" element={<ManagePoint />} />
            <Route path="manage-point/:calendarId" element={<DetailPoint />} />
            <Route path="config-point" element={<ConfigPoint />} />
        </Route>
        <Route path="*" element={<NotFound />}/>
      </Routes>
      <ToastContainer />
  </BrowserRouter>
  );
}

export default App;
