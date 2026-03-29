import { useState } from "react";

function AdminRegister({ setShowLogin }) {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  // 🏨 Hotel fields
  const [hotelName, setHotelName] = useState("");
  const [location, setLocation] = useState("");

  const handleRegister = async () => {
    try {
      const res = await fetch("http://localhost:8080/admin/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username,
          email,
          password,

          // 🔥 Hotel object
          hotel: {
            name: hotelName,
            location: location,
            rating: 0,
          },
        }),
      });

      if (res.ok) {
        alert("Admin Registered Successfully!");
        setShowLogin(false); // 🔥 go back to login
      } else {
        alert("Registration failed");
      }
    } catch (err) {
      console.error(err);
      alert("Server error");
    }
  };

  return (
    <div>
      <h2>Admin Register</h2>

      <input
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <br />

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />

      {/* 🏨 HOTEL DETAILS */}
      <h3>Hotel Details</h3>

      <input
        placeholder="Hotel Name"
        value={hotelName}
        onChange={(e) => setHotelName(e.target.value)}
      />
      <br />

      <input
        placeholder="Location"
        value={location}
        onChange={(e) => setLocation(e.target.value)}
      />
      <br />

      <button onClick={handleRegister}>Register</button>

      <p>
        Already have account?{" "}
        <button onClick={() => setShowLogin(false)}>Login</button>
      </p>
    </div>
  );
}

export default AdminRegister;