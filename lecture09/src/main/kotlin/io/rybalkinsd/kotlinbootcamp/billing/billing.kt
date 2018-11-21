package io.rybalkinsd.kotlinbootcamp.billing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE
import org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Broken implementation of billing service
 * Money are lost here
 */
@Controller
@RequestMapping("billing")
class BillingResource {
    private val userToMoney = mutableMapOf<String, Int>()

    /**
     * curl localhost:8080/billing/stat
     */
    val stat: ResponseEntity<String>
        @RequestMapping(path = ["stat"], method = [GET], produces = [TEXT_PLAIN_VALUE])
        get() = ResponseEntity.ok(userToMoney.toString() + "\n")

    /**
     * curl -XPOST localhost:8080/billing/addUser -d "user=sasha&money=100000"
     * curl -XPOST localhost:8080/billing/addUser -d "user=sergey&money=100000"
     */
    @RequestMapping(
        path = ["addUser"],
        method = [POST],
        consumes = [APPLICATION_FORM_URLENCODED_VALUE]
    )
    @ResponseStatus(HttpStatus.OK)
    fun addUser(@RequestParam("user") user: String?,
                @RequestParam("money") money: Int?): ResponseEntity<String> {

        if (user == null || money == null) {
            return ResponseEntity.badRequest().body("")
        }
        userToMoney[user] = money

        return ResponseEntity.ok("Successfully created user [$user] with money ${userToMoney[user]} \n")
    }

    @RequestMapping(
        path = ["sendMoney"],
        method = [POST],
        consumes = [APPLICATION_FORM_URLENCODED_VALUE]
    )
    @ResponseStatus(HttpStatus.OK)
    fun sendMoney(@RequestParam("from") fromUser: String?,
                  @RequestParam("to") toUser: String?,
                  @RequestParam("money") money: Int?): ResponseEntity<String> {
        if (fromUser == null || toUser == null || money == null) {
            return ResponseEntity.badRequest().body("")
        }
        if (!userToMoney.containsKey(fromUser) || !userToMoney.containsKey(toUser)) {
            return ResponseEntity.badRequest().body("No such user\n")
        }
        if (userToMoney[fromUser]!! < money) {
            return ResponseEntity.badRequest().body("Not enough money to send\n")
        }
        userToMoney[fromUser] = userToMoney[fromUser]!! - money
        userToMoney[toUser] = userToMoney[toUser]!! + money

        return ResponseEntity.ok("Send success\n")
    }
}

@SpringBootApplication
class BillingApp

fun main(args: Array<String>) {
    runApplication<BillingApp>(*args)
}