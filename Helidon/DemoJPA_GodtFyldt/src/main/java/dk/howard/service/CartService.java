package dk.howard.service;

import dk.howard.domain.Cart;
import dk.howard.repository.Repository;
import dk.howard.service.request.CreateCartRequest;
import dk.howard.service.request.CreateItemRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional(rollbackOn = Exception.class)
public class CartService {

    private final Repository repository;

    @Inject
    public CartService(Repository repository) {
        this.repository = repository;
    }

    public Cart createCart(CreateCartRequest request) {
        return repository.createCart1(request.getName());
    }

    public List<Cart> getCarts() {
        return repository.findAllCarts();
    }

    public Cart createItem(CreateItemRequest request) {
        return repository.createItem1(request.getCartId(), request.getName(), request.getPrice());
        //return repository.createItem(request.getCartId(), request.getName(), request.getPrice());
    }
}
