<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un produit</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer" />
</head>
<body>
    <div class="container">
        <div class="card mt-4">
            <div class="card-header bg-primary text-white">
                <h2 class="m-0">Ajouter un produit</h2>
            </div>
            <div class="card-body">
                <form class="form" method="post" action="controlleur">
                    <div class="form-group row">
                        <label for="name" class="col-md-2 col-form-label text-md-right">Nom :</label>
                        <div class="col-md-10">
                            <input type="text" id="name" name="name" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="prix" class="col-md-2 col-form-label text-md-right">Prix :</label>
                        <div class="col-md-10">
                            <input type="number" id="prix" name="prix" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="quantities" class="col-md-2 col-form-label text-md-right">Quantité :</label>
                        <div class="col-md-10">
                            <input type="number" id="quantities" name="quantities" class="form-control" required>
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" name="action" value="ajout" class="btn btn-primary">Ajouter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
