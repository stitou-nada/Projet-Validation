<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class filmAvoir extends Model
{

    use HasFactory;
    protected $table= "filmAvoir";
    public $timestamps = false;
    protected $fillable=[
        "id",
            'film_id',
            'title',
             "release_date",
             "vote_average",
             "overview",
             "popularity",
             "backdrop_path"
    ];
}



