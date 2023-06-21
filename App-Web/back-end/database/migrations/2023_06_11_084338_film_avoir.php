<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('filmAvoir', function (Blueprint $table) {
            $table->id();
            $table->integer('film_id');
            $table->string('title')->nullable();
            $table->string('release_date')->nullable();
            $table->string('vote_average')->nullable();
            $table->text('overview')->nullable();
            $table->string('popularity')->nullable();
            $table->string('backdrop_path')->nullable();
            $table->string('type')->nullable();
            $table->timestamps();
        });
    }


    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        //
    }
};
