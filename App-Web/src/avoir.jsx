import { Modal,show,Button} from 'react-bootstrap';
import React, { useState } from "react";
import axios from 'axios';
const API_IMG="https://image.tmdb.org/t/p/w500/";
const Avoir =({title, backdrop_path, vote_average, release_date,film_id, overview ,id})=>{

    const [show, setShow]=useState(false);
    const handleShow=()=>setShow(true);
    const handleClose=()=>setShow(false);
   
    const handleDelete=()=>{
        axios.delete("http://127.0.0.1:8000/api/delete/"+film_id)
        .then((res)=>{
                // console.log(res.data)
                alert('Vous avez sure supprimer ce film')
                window.location.reload()
            }
        )
    
      
 }
return(
    <div>
   
    <div className="card text-center bg-secondary mb-3">
    <div className="card-body">
        <img className="card-img-top" src={API_IMG+backdrop_path} />
        <div className="card-body">
        <button type="button" className="btn btn-dark" onClick={handleShow}>Détail</button>
         <button type="button" className="btn btn-danger" id='delete' onClick={handleDelete}>-</button>
        <Modal  show={show} onHide={handleClose}>
        <Modal.Header closeButton>
            <Modal.Title></Modal.Title>
            </Modal.Header>
            <Modal.Body>
                  <img className="card-img-top" style={{width:'14rem'}}src={API_IMG+backdrop_path} />
                  <h3>{title}</h3>
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
</div>

)
}
export default Avoir;