import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./page/home";
import Agregar from "./page/agregar";
import Modificar from "./page/modificar";

function App(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/agregar" element={<Agregar/>}/>
                <Route path="/modificar/:id" element={<Modificar/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export default App;