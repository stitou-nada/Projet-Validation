import { Modal,show,Button} from 'react-bootstrap';
import React, { useState } from "react";
import axios from 'axios';
import { useEffect } from 'react';

const API_IMG="https://image.tmdb.org/t/p/w500/";
const MovieBox =({titel, poster_path, vote_average, release_date, overview ,id})=>{
    const [show, setShow]=useState(false);
    const handleShow=()=>setShow(true);
    const handleClose=()=>setShow(false);
   
    const selectType=(e)=>{
          console.log(e.target.value)
          console.log(id)
          axios.get("https://api.themoviedb.org/3/movie/"+id+"?api_key=425414f904f9e89890479e354293848b")
          .then((res)=>{ 
         
              res.data.type=e.target.value
               console.log(res.data)
               axios.post("http://127.0.0.1:8000/api/store",res.data)
               .then((res)=>
                       console.log('dd')
               )
            })
    }

    const handleDelete=()=>{
           console.log(id)
         
    }
    // useEffect(() => {
    //     axios.get('http://localhost:8000/api/ExisteMovie/'+id)
    //     .then(res=>{
    //       console.log(res.data)


    //       if(res.data.message== "true"){
    //         const btnRemove = document.getElementById("delete")
    //         btnRemove.style.display='inline'
    //       }
    //       else{
    //       const btnAdd = document.getElementById("select")
    //       btnAdd.style.display='inline'
    //       console.log('err')
    //     }
    //     //   setLeague(res.data);
    //     }
    //     )
    
      
    // }, [])
    
    
   return(
    <div className="card text-center bg-secondary mb-3" >
        <div className="card-body" style={{backgroundColor:'#0b2456'}}>
            <img className="card-img-top" src={API_IMG+poster_path} />
            <div className="card-body">
            <button type="button" className="btn btn-dark"  onClick={handleShow}>Détail</button>
            {/* <button type="button" className="btn btn-danger" id='delete' style={{display:'none'}} onClick={handleDelete}>-</button> */}
            <select onChange={selectType}  className="btn btn-warning selectAvoire" id="select">
             <option disabled selected value >  Ajouter dans liste avoir  </option>
                <option value="Familier">Familier</option>
                <option value="Enfant">Enfant</option>
                <option value="Personel">Personel</option>
            </select>
            <Modal  show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title></Modal.Title>
                </Modal.Header>
                <Modal.Body>
                      <img className="card-img-top" style={{width:'14rem'}}src={API_IMG+poster_path} />
                      <h3>{titel}</h3>
                      <h4>IMDb: {vote_average}</h4>
                      <h5>Release Date: {release_date}</h5>
                      <br></br>
                      <h6>Overview</h6>
                      <p>{overview}</p>
                </Modal.Body>
                <Modal.Footer>
                          <Button variant="secondary" onClick={handleClose}>Close</Button>
                      </Modal.Footer>
            </Modal>
            </div>
        </div>
       
    </div>
   )
}
export default MovieBox;