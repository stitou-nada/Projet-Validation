<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;

class loginController extends Controller
{
    function Login(Request $request)
    {

        $user = User::select("id", "password", "email")->where([
            ["email", $request->email],
            ["password", $request->password]
        ])->first();


        if ($user) {

            return $user;
        } else {
            return false;
        }
    }
}
