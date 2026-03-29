import { useState } from "react";

function AdminPage({ user }) {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");

  const hotelId = user?.hotel?.id;

  const handleAddFood = async () => {
    if (!hotelId) {
      alert("No hotel linked to admin");
      return;
    }

    const res = await fetch("http://localhost:8080/menu/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name,
        price: parseInt(price),
        hotel: {
          id: hotelId,
        },
      }),
    });

    if (res.ok) {
      alert("Food Added Successfully!");
      setName("");
      setPrice("");
    } else {
      alert("Error adding food");
    }
  };

  return (
    <div>
      <h2>Admin Page</h2>

      {/* 🔥 SHOW ADMIN HOTEL */}
      <h3>Your Hotel ID: {hotelId}</h3>

      <input
        placeholder="Food Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <br />

      <input
        type="number"
        placeholder="Price"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />

      <br /><br />

      <button onClick={handleAddFood}>Add Food</button>
    </div>
  );
}

export default AdminPage;