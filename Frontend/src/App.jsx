import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import LogIn from './sections/Login/LogIn';
import HomeAdmin from "./sections/AdminHome/HomeUi4";
import HomeResident from "./sections/ResidentHome/HomeUiResident";
import SignUp from './sections/Login/SignUp';
import AdminDetails from './sections/Login/AdminDetails';
import ResidentDetails from './sections/Login/ResidentDetails';
import SuccessPhe from './sections/Login/SuccessPage';

export default function App() {
  return (

<Router>
      <Routes>
         <Route path="/" element={<LogIn/>} />
         <Route path="/homeAdmin" element={<HomeAdmin />} />
         <Route path="/homeResident" element={<HomeResident />} /> 
<Route path="/signup" element={<SignUp />} />
<Route path="/admin-details" element={<AdminDetails />} />
<Route path="/resident-details" element={<ResidentDetails />} />
<Route path="/success" element={<SuccessPhe />} />
<Route path="/login" element={<LogIn />} />
      </Routes>
</Router>

  
  );
}
