<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class stagiaire extends Model
{
    use HasFactory;
    protected $table= "stagiaire";
    public $timestamps = false;
    protected $fillable=[
        'Nom',
        'Prenom'
    ];
}
