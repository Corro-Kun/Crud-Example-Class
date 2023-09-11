import {useNavigate, useParams} from "react-router-dom"
import axios from "axios";
import { useState, useEffect } from "react";

function Modificar(){
    const navigete = useNavigate();
    const [producto, setProducto] = useState({nombre: "", cantidad: 0});
    const GetProduct = (id)=> axios.get(`http://localhost:8080/catalogo/${id}`);
    const PutProduct = (id, data)=> axios.put(`http://localhost:8080/catalogo/${id}`, data);
    const {id} = useParams();

    async function Recuperar(){
        const {data} = await GetProduct(id);
        setProducto(data);
    }

    useEffect(()=>{
        Recuperar();
    },[]);

    function cambiaData({target:{name, value}}){
        setProducto({...producto,[name]: value});
    }

    async function ModificarProducto(e){
        e.preventDefault();
        await PutProduct(id, producto);
        navigete("/");
    } 

    return(
        <form onSubmit={(e)=> ModificarProducto(e)} >
            <input value={producto.nombre} type="text" name="nombre" placeholder="Nombre" onChange={
                (e)=> cambiaData(e)
            } />
            <input value={producto.cantidad} type="number" name="cantidad" placeholder="Cantidad" onChange={
                (e)=> cambiaData(e)
            } />
            <button type="submit">Modificar producto</button>
        </form>
    );
}

export default Modificar;