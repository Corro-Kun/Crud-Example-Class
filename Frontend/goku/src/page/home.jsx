import axios from 'axios';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Home(){
    const [catalogo, setCatalogo] = useState([]); 
    const GetCatalogoApi = ()=> axios.get("http://localhost:8080/catalogo");
    const DeleteCatalogoApi = (id)=> axios.delete(`http://localhost:8080/catalogo/${id}`);
    const navigation = useNavigate();

    useEffect(()=>{
        GetCatalogo();
    },[catalogo]);

    async function GetCatalogo(){
        const {data} = await GetCatalogoApi();
        setCatalogo(data);
        console.log(data);
    }

    return(
        <div>
            <h2 style={{color: "red"}} >Productos</h2>
            <button onClick={()=> navigation("/agregar")} >Agregar</button>
            {
                catalogo.map((a)=>(
                    <div>
                        <h2>{a.nombre}</h2>
                        <p>{a.cantidad}</p>
                        <button onClick={()=> navigation("/modificar/"+a.idproducto)} >Modificar</button>
                        <button onClick={()=> {
                            DeleteCatalogoApi(a.idproducto);
                            catalogo.map((a)=>{
                                if(a.idproducto === a.idproducto){
                                    catalogo.splice(a, 1);
                                }
                            })
                        }} >Eliminar</button>
                    </div>
                ))
            }
        </div>
    )
}

export default Home;