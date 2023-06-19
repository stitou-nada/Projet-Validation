import './App.css';
import React,{useState,useEffect} from 'react';
import MovieBox from './MovieBox';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button, Container, Form, FormControl, Nav, Navbar, NavbarBrand } from 'react-bootstrap';
import NavbarToggle from 'react-bootstrap/esm/NavbarToggle';
import NavbarCollapse from 'react-bootstrap/esm/NavbarCollapse';
import Avoir from './avoir';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import axios from 'axios';


const API_URL="https://api.themoviedb.org/3/movie/popular?api_key=bcc4ff10c2939665232d75d8bf0ec093";
const API_SEARCH="https://api.themoviedb.org/3/search/movie?api_key=<<api_key_here>>&query";
function App(){
  const [movies, setMovies]=useState([]);
  const [avoirList, setAvoirList]=useState([]);
  const [query, setQuery]=useState('');
useEffect(()=>{
   if(document.URL== "http://localhost:3000/avoir"){
      const select= document.getElementById('test')
      select.style.display= 'inline'
  }
  fetch(API_URL)
  .then((res)=>res.json())
  .then(data=>{
    // console.log(data);
    setMovies(data.results);
    
  })
  fetch("http://127.0.0.1:8000/api/ListAvoir")
  .then((res)=>res.json())
  .then(data=>{
    console.log(data);
    setAvoirList(data);
  })
},[])

const searchMovie = async(e)=>{
  e.preventDefault();
  console.log("Searching");
  try{
    const url=`https://api.themoviedb.org/3/search/movie?api_key=bcc4ff10c2939665232d75d8bf0ec093&query=${query}`;
    const res= await fetch(url);
    const data= await res.json();
    console.log(data);
    setMovies(data.results);
  }
  catch(e){
    console.log(e);
  }
}

const selectType=(e)=>{
  console.log(e.target.value)
  axios.get("http://127.0.0.1:8000/api/select/"+e.target.value)
  .then((res)=>{  
       console.log(res.data)
       setAvoirList(res.data);
    })
}

const changeHandler=(e)=>{
  setQuery(e.target.value);
}
  return (
    <>
    <Navbar expand="lg" variant="dark" style={{backgroundColor:'#0b2456'}}>
      <Container fuild>
        <NavbarBrand href="/">Accueil</NavbarBrand>
        <NavbarBrand href="/avoir">FilmAvoir</NavbarBrand>
        <NavbarToggle aria-controls="navbarScroll"></NavbarToggle>
        <NavbarCollapse id="nabarScroll">
          <Nav className="me-auto my-2 my-lg-3" style={{maxHeight:'100px'}} navbarScroll ></Nav>
          <Form className="d-flex" onSubmit={searchMovie} autoComplete="off">
          <FormControl
              type="search"
              placeholder="Rechercher"
              className="me-2"
              aria-label="search"
              name="query"
              value={query} onChange={changeHandler}></FormControl>
               <Button variant="secondary" type="submit">Rechercher</Button>
          </Form>
        </NavbarCollapse>
      </Container>
    </Navbar>
    <div>
    <div className='select'>
      
      
        {/* <button type="button" className="btn btn-dark" id='btn' onClick={()=>Avoir(id)}>select</button> */}
            <select id="test" style={{display:'none'}} onChange={selectType} className="btn btn-warning " >
            <option disabled selected value>  selectione type </option>
                <option value="Familier">Familier</option>
                <option value="Enfant">Enfant</option>
                <option value="Personel">Personel</option>
            </select>
        </div>
    <div className='container'>
      <div className='grid'>
    <BrowserRouter>
     <Routes>
    
      <Route path='/' element={movies.map((movieReq)=> <MovieBox key={movieReq.id}{...movieReq} />)}></Route>
      <Route path='/avoir' element={avoirList.map((List)=> <Avoir key={List.id}{...List} />)}></Route>
      
     </Routes>
     </BrowserRouter>
      
      </div>
    </div>
    
     </div>
    </>
  );
}
export default App;