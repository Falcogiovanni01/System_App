ui = true

storage "file" {
  path = "/vault/data"
}

listener "tcp" {
  address     = "0.0.0.0:8200"
  tls_disable = 1
}

# In Docker, meglio non usare localhost qui se possibile, 
# ma per ora lascialo così se non ti dà problemi di redirect.
# L'ideale sarebbe: api_addr = "http://vault:8200" 
api_addr = "http://0.0.0.0:8200" 

disable_mlock = true
log_level = "info"