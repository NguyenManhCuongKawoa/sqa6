import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./login";
import Main from "./Main";
import { NotFound } from "./NotFound";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Login />} />
        <Route path="/main" >
          <Route index element={<Main />} />
        </Route>
        <Route element={<NotFound />}/>
      </Routes>
  </BrowserRouter>
  );
}

export default App;
