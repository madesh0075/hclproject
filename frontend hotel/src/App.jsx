import { useEffect, useState } from "react";
import Login from "./pages/Login";
import UserPage from "./pages/UserPage";
import AdminPage from "./pages/AdminPage";

function App() {
  const [user, setUser] = useState(null);

  // 🔥 Load user from localStorage on refresh
  useEffect(() => {
    const storedUser = localStorage.getItem("user");

    if (storedUser) {
      setUser(JSON.parse(storedUser));
    }
  }, []);

  // 🔥 Save user when login
  const handleSetUser = (data) => {
    setUser(data);
    localStorage.setItem("user", JSON.stringify(data));
  };

  // 🔥 Logout
  const handleLogout = () => {
    setUser(null);
    localStorage.removeItem("user");
  };

  return (
    <div>
      <h1>Food App</h1>

      {!user && <Login setUser={handleSetUser} />}

      {user && (
        <button onClick={handleLogout}>Logout</button>
      )}

      {user?.role === "USER" && <UserPage user={user} />}
      {user?.role === "ADMIN" && <AdminPage user={user} />}
    </div>
  );
}

export default App;