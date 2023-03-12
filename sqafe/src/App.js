import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./login";
import Main from "./Main";
import { NotFound } from "./NotFound";
import ConfigPoint from "./pages/ConfigPoint";
import DetailPoint from "./pages/DetailPoint";
import { Home } from "./pages/Home";
import { ManagePoint } from "./pages/ManagePoint";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" exact element={<Login />} />
        <Route path="/" element={<Main />} >
          <Route index element={<Home />} />
          <Route path="manage-point" element={<ManagePoint />} />
          <Route path="manage-point/:userId" element={<DetailPoint />} />
          <Route path="config-point" element={<ConfigPoint />} />
        </Route>
        <Route path="*" element={<NotFound />}/>
      </Routes>
  </BrowserRouter>
  );
}

export default App;
