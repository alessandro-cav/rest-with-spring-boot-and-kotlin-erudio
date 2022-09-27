package br.com.erudio

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter : AtomicLong = AtomicLong()

    //o simbolo ? quer dizer que permite que o valor seja nulo
    // defaultValue serve para ter um valor padrao caso o paramentro name nao tenha valor seja nulo
    // $name assim pegamos o valor do paramentro da url ou do defaultValue para mostrar na tela
    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name : String? ) : Greeting{
        return Greeting(counter.incrementAndGet(),"Hello, $name")
    }

    // http://localhost:8080/greeting mostra opr padrao o defaultValue:  o content: "Hello, World"
    // http://localhost:8080/greeting?name=ale monstra qualquer valor que for passado no paramentro name
    // content: "Hello, ale"
}