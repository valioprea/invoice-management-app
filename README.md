## invoice-management-app
Java SpringBoot based application that manages invoices through REST API

## What is it about?

You can create, view and delete invoices of products of your choice and store them in a database.

Additionally, it's possible to print them out to PDF.

# Routing
/invoices GET - view all invoices
/invoice POST - create an invoice & store to dbs
/invoice/{id} GET - specific invoice by Id
/invoice/{id} DELETE - specific invoice

/invoice/{id}/print GET - print to pdf specific invoice
/invoice/printall GET - print to pdf all invoices

# How does an invoice look like ?
{
        "name": "Vali",
        "receiverName": "Dani",
        "itemList": [
            {
                "itemName": "cars",
                "itemInfo": {
                    "quantity": 3,
                    "price": 10
                }
            },
            {
                "itemName": "bananas",
                "itemInfo": {
                    "quantity": 2,
                    "price": 50
                }
            }
        ],
        "priceWithVAT": 300,
        "priceWithoutVAT": 250
}

# Have fun!
