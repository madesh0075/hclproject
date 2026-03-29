import { useEffect, useState } from "react";

function UserPage({ user }) {
  const [hotels, setHotels] = useState([]);
  const [selectedHotel, setSelectedHotel] = useState(null);
  const [cart, setCart] = useState([]);

  // 🔥 FETCH ALL HOTELS
  useEffect(() => {
    fetch("http://localhost:8080/hotel/all")
      .then((res) => res.json())
      .then((data) => {
        console.log("HOTEL DATA:", data);
        setHotels(data);
      })
      .catch((err) => console.error(err));
  }, []);

  // 🔥 FETCH MENU WHEN HOTEL CLICKED
  const fetchMenu = (hotel) => {
    fetch(`http://localhost:8080/menu/hotel/${hotel.id}`)
      .then((res) => res.json())
      .then((data) => {
        setSelectedHotel({
          ...hotel,
          foods: data,
        });
      })
      .catch((err) => console.error(err));
  };

  // 🔥 ADD TO CART
  const addToCart = (food) => {
    const existing = cart.find((item) => item.id === food.id);

    if (existing) {
      setCart(
        cart.map((item) =>
          item.id === food.id
            ? { ...item, quantity: item.quantity + 1 }
            : item
        )
      );
    } else {
      setCart([...cart, { ...food, quantity: 1 }]);
    }
  };

  // 🔥 REMOVE FROM CART
  const removeFromCart = (id) => {
    setCart(cart.filter((item) => item.id !== id));
  };

  // 🔥 TOTAL
  const total = cart.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0
  );

  // 🔥 CONFIRM ORDER
  const confirmOrder = async () => {
    if (!user || !user.email) {
      alert("User not logged in");
      return;
    }

    const foodNames = cart.map((item) => item.name).join(",");

    const res = await fetch(
      `http://localhost:8080/user/order/add-order?email=${user.email}`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          food: foodNames,
          totalprice: total,
          status: "ORDERED",
        }),
      }
    );

    if (res.ok) {
      alert("Order Confirmed! 📧 Email Sent");
      setCart([]);
    } else {
      alert("Order failed");
    }
  };

  return (
    <div>
      <h2>User Page</h2>

      {/* 🏨 HOTEL LIST */}
      {!selectedHotel &&
        hotels.map((hotel) => (
          <div
            key={hotel.id}
            onClick={() => fetchMenu(hotel)}
            style={{
              border: "1px solid black",
              margin: "10px",
              padding: "10px",
              cursor: "pointer",
            }}
          >
            <h3>{hotel.name}</h3>
            <p>{hotel.location}</p>
          </div>
        ))}

      {/* 🍽 MENU */}
      {selectedHotel && (
        <div>
          <button onClick={() => setSelectedHotel(null)}>⬅ Back</button>

          <h3>{selectedHotel.name} Menu</h3>

          {selectedHotel?.foods?.length === 0 && (
            <p>No food available</p>
          )}

          {selectedHotel?.foods?.map((food) => (
            <div
              key={food.id}
              style={{
                border: "1px solid gray",
                margin: "5px",
                padding: "5px",
              }}
            >
              {food.name} - ₹{food.price}

              <button onClick={() => addToCart(food)}>Add</button>
            </div>
          ))}
        </div>
      )}

      {/* 🛒 CART */}
      <h3>Cart</h3>

      {cart.length === 0 && <p>No items in cart</p>}

      {cart.map((item) => (
        <div key={item.id}>
          {item.name} x {item.quantity} = ₹{item.price * item.quantity}

          <button onClick={() => removeFromCart(item.id)}>Remove</button>
        </div>
      ))}

      <h4>Total: ₹{total}</h4>

      {cart.length > 0 && (
        <button onClick={confirmOrder}>Confirm Order</button>
      )}
    </div>
  );
}

export default UserPage;