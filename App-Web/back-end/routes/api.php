<?php

use App\Http\Controllers\loginController;
use App\Http\Controllers\movieController;
use App\Http\Controllers\stagiaireController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('getAPI',[movieController::class,'getAPI']);
Route::get('filmDetail/{film_id}',[movieController::class,'filmDetail']);
Route::post('store',[movieController::class,'store']);
Route::post('storeWeb',[movieController::class,'storeWeb']);

Route::post("login",[loginController::class,'Login']);




Route::get('ListAvoir',[movieController::class,'ListAvoir']);
Route::get('select/{type}',[movieController::class,'select']);
Route::get('ExisteMovie/{id}',[movieController::class,'ExisteMovie']);
Route::delete('delete/{id}',[movieController::class,'delete']);

