import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Agregar(){
    const navigate = useNavigate();
    const PostCatalogo = (data)=> axios.post("http://localhost:8080/catalogo", data);
    const [producto, setProducto] = useState({nombre: "", cantidad: 0});

    function cambiaData({target:{name, value}}){
        setProducto({...producto,[name]: value});
    }

    async function AgregarProducto(e){
        e.preventDefault();
        await PostCatalogo(producto);
        navigate("/");
    }

    return(
        <form onSubmit={(e)=> AgregarProducto(e)} >
            <input type="text" name="nombre" placeholder="Nombre" onChange={(e)=> cambiaData(e)} />
            <input type="number" name="cantidad" placeholder="Cantidad" onChange={(e)=> cambiaData(e)} />
            <button type="submit">Agregar producto</button>
        </form>
    )
}

export default Agregar;