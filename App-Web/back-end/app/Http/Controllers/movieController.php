<?php

namespace App\Http\Controllers;

use App\Models\filmAvoir;
use App\Models\filmFavorie;
use Illuminate\Http\Request;

class movieController extends Controller
{

    public function getAPI(){
        // Create nouveau bebliotheque php
        $client = new \GuzzleHttp\Client([
            'verify' => false
        ]);

        // envoye un HTTP GET request a URL
        $response = $client->request('GET', 'https://api.themoviedb.org/3/movie/popular?api_key=bcc4ff10c2939665232d75d8bf0ec093');

        $data = $response->getBody()->getContents();
        $data = json_decode($data, true);

        $result =  $data["results"];
        $arrayData = array();
        foreach($result as $movie){
            $id= $movie['id'];
            $arrayData[] = [
                "film_id" => $id,
                "title" => $movie['title'],
                "release_date" => $movie['release_date'],
                "vote_average" => $movie['vote_average'],
                "popularity" => $movie['popularity'],
                "overview" => $movie['overview'],
                "backdrop_path" => $movie['backdrop_path']
            ];
        }

            return $arrayData;



    }


    function filmDetail($film_id){

        $client = new \GuzzleHttp\Client([
            'verify' => false
        ]);

        // envoye un HTTP GET request a URL
        $response = $client->request('GET', 'https://api.themoviedb.org/3/movie/'.$film_id.'?api_key=bcc4ff10c2939665232d75d8bf0ec093');

        $data = $response->getBody()->getContents();
        $data = json_decode($data, true);

            $id= $data['id'];
            $arrayData[] = [
                "film_id" => $id,
                "title" => $data['title'],
                "release_date" => $data['release_date'],
                "vote_average" => $data['vote_average'],
                "popularity" => $data['popularity'],
                "overview" => $data['overview'],
                "backdrop_path" => $data['backdrop_path']
            ];


            return $arrayData[0];



    }

    public function store(Request $request)
    {
    $store = new filmAvoir();
        $store->film_id = $request->film_id;
        $store->title =$request->title;
        $store->release_date =$request->release_date;
        $store->vote_average =$request->vote_average;
        $store->overview =$request->overview;
        $store->popularity =$request->popularity;
        $store->backdrop_path =$request->backdrop_path;

        $store->save();
        return true ;
    }


    public function ListAvoir(){

        $list = filmAvoir::select("film_id","title","release_date","vote_average","overview","popularity","backdrop_path")->get();

        $films = $list->map(function ($item) {
            return [
                'film_id' => (int) $item->film_id,
                'title' => (string) $item->title,
                'release_date' => (string) $item->release_date,
                'vote_average' => (double) $item->vote_average,
                'overview' => (string) $item->overview,
                'popularity' => (double) $item->popularity,
                'backdrop_path' => (string) $item->backdrop_path,
            ];
            });

        return $films;
    }
    public function select($type){

        $select = filmAvoir::where('type' , $type )->get();
        return $select;
    }

    public function ExisteMovie($id){
        $list = filmAvoir::where("id",$id)->get();
        if(!empty($list[0])){
            return ['message'=>"true"];
        }else{
            return ['message'=>"false"];

        }
    }
    public function delete($id){

        filmAvoir::where('film_id',$id)->delete();
        // $list = filmAvoir::select("*")->get();

         return true;
    }
    public function storeWeb(Request $request)
    {
    $store = new filmAvoir();
        $store->title = $request->title;
        $store->film_id = $request->id;
        $store->overview = $request->overview;
        $store->release_date = $request->release_date;
        $store->vote_average = $request->vote_average;
        $store->popularity = $request->popularity;
        $store->backdrop_path = $request->backdrop_path;
        $store->type = $request->type;
        $store->save();

    }

}
