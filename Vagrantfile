# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = '2'

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  if Vagrant.has_plugin?("vagrant-cachier")
      config.cache.scope = :box
      config.cache.auto_detect = false
      config.cache.enable :apt
  end
  config.vm.box = "ubuntu/trusty32"
  config.ssh.forward_agent = true
  config.ssh.shell = "bash -c 'BASH_ENV=/etc/profile exec bash'"
  config.vm.hostname = "linux"
  config.vm.provision :shell do |sh|
    sh.privileged = false
    sh.path = "provision.sh"
  end
end